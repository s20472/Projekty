using System;
using System.Collections.Generic;

#nullable disable

namespace TreningPrzedKolokwium.Models
{
    public partial class MieszkaniecPomieszczenie
    {
        public int MieszkaniecIdclient { get; set; }
        public int PomieszczenieIdpomieszczenie { get; set; }
        public DateTime DataWynajecia { get; set; }
    }
}
