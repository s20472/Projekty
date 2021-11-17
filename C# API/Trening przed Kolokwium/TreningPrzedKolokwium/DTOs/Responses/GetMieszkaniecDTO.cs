using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TreningPrzedKolokwium.Models;

namespace TreningPrzedKolokwium.DTOs.Responses
{
    public class GetMieszkaniecDTO
    {
        public int Idclient { get; set; }
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public DateTime DataUrodzenia { get; set; }
        public List<Pomieszczenie> Pomieszczenia { get; set; }
    }
}
