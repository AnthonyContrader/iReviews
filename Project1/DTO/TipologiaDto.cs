using Project1.Model;
using System;

namespace Project1.DTO
{
    public class TipologiaDto
    {
        public int? Id { get; set; }
        public string NomeTipologia { get; set; }

        public Tipologia ConvertTo()
        {
            return new Tipologia
            {
                Id = this.Id,
                NomeTipologia = this.NomeTipologia,

            };
        }
        public static TipologiaDto ConvertFrom(Tipologia tipologia)
        {
            return new TipologiaDto
            {
                Id = tipologia.Id,
                NomeTipologia = tipologia.NomeTipologia,

            };
        }

        internal static TipologiaDto ConvertFrom(object tipologia)
        {
            throw new NotImplementedException();
        }
    }
}

