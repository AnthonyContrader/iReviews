using System.Collections.Generic;

namespace Project1.Model
{
    public class Localita : BaseModel
    {
        public string Citta { get; set; }
        public string Provincia { get; set; }
        public string Stato { get; set; }
        public IList<Esercizio> EserciziPerLocalita { get; set; }

    }
}
