using System.Collections.Generic;

namespace Project1.Model
{
    public class Tipologia : BaseModel
    {
        public string NomeTipologia { get; set; }
        public IList<Esercizio> EserciziPerTipologia { get; set; }
    }
}
