import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyServer 
{
	private static List <Integer> Unique = new ArrayList<Integer>();
	private static List <DatagramSocket> UDPSockets = new ArrayList<DatagramSocket>();
	private volatile static HashMap<InetAddress,int[]> inputs = new HashMap<InetAddress,int[]>();
	
	synchronized static boolean knock(InetAddress clientAddress, int port,int[]args)
	{
		if(inputs.containsKey(clientAddress))
		{
			inputs.put(clientAddress,new int[args.length]);
		}
		for(int j=0;j<inputs.get(clientAddress).length-1;j++)
		{
			inputs.get(clientAddress)[j] = inputs.get(clientAddress)[j+1];
		}
		inputs.get(clientAddress)[inputs.get(clientAddress).length]=port;
		boolean result = true;
		for(int i=0;i<args.length;i++)
		{
			if(inputs.get(clientAddress)[i] != args[i])
				result = false;
		}
		if(result)
			for(int i=0;i<inputs.get(clientAddress).length;i++)
				inputs.get(clientAddress)[i]=0;
		return result;
	}
	
	public static void main(int args[])  
    {
		for(int i=0;i<args.length;i++)
		{
			if(!Unique.contains(args[i]))
				Unique.add(args[i]);
		}
		for(int i=0;i<Unique.size();i++)
		{
			try 
			{
				UDPSockets.add(new DatagramSocket(Unique.get(i)));
				if(Unique.get(i)<1025)throw new SocketException();
				
			}
			catch (SocketException e) 
			{
				System.out.println("Nie mozna utworzyæ cocketa UDP na jednym z podanych adresów");
			}
			final DatagramSocket x = UDPSockets.get(UDPSockets.size()-1);
			//W¹tek nas³uchuj¹cy
			new Thread(() ->  
			{
				final DatagramSocket socket = x;
				while(true) 
				{
					try 
					{
						final DatagramPacket datagram = new DatagramPacket(new byte[508], new byte[508].length);
						socket.receive(datagram);
						new Thread(() -> 
						{
							InetAddress clientAddress = datagram.getAddress();
							if(knock(clientAddress, datagram.getPort(), args))
							{
								try 
								{
									ServerSocket TCPserver = new ServerSocket((int)((Math.random()*10000%2000)+1024));
									byte[] response = String.valueOf(TCPserver.getLocalPort()).getBytes();
									socket.send(new DatagramPacket(response, response.length, clientAddress, datagram.getPort()));
									Socket TCPclient = TCPserver.accept();
									BufferedReader in = new BufferedReader(new InputStreamReader(TCPclient.getInputStream()));
						            PrintWriter out = new PrintWriter(TCPclient.getOutputStream(), true);
						            String input = in.readLine();
						            out.println("Otrzymano wiadomosc: " + input);
						            out.println("Odsylam podwojon¹ wiadomosc: " + input + " " + input);
						            TCPclient.close();
								} 
								catch (IOException e) 
								{
									System.out.println("Nie mozna utworzyc Socketa TCP");
								}
							}
						}).start();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					} 
		        }
			}).start();
		}		
    }
}
