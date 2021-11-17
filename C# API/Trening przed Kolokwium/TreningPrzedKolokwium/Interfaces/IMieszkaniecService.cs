using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TreningPrzedKolokwium.DTOs;
using TreningPrzedKolokwium.DTOs.Responses;
using TreningPrzedKolokwium.Models;

namespace TreningPrzedKolokwium.Interfaces
{
    public interface IMieszkaniecService
    {
        public Task<IEnumerable<GetMieszkaniecDTO>> GetMieszkancy();
        public Task<String> CreateMieszkaniec(CreateMieszkaniecDTO mieszkaniec);

        public Task<String> DeleteMieszkaniec(int ID);

        public Task<String> RentPomieszczenie(int mieszkaniecID,int pomieszczenieID);
    }
}
