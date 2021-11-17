using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TreningPrzedKolokwium.DTOs;
using TreningPrzedKolokwium.Models;

namespace TreningPrzedKolokwium.Interfaces
{
    public interface IPomieszczenieService
    {
        public Task<IEnumerable<Pomieszczenie>> getPomieszczenia();
        public Task<String> AddPomieszczenie(CreatePomieszczenieDTO pomieszczenie);
    }
}
