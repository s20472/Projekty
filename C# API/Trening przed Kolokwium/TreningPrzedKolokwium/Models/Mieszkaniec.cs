using System;
using System.Collections.Generic;

#nullable disable

namespace TreningPrzedKolokwium.Models
{
    public partial class Mieszkaniec
    {
        public int Idclient { get; set; }
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public DateTime DataUrodzenia { get; set; }
    }
}
