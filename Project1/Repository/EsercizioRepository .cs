using Project1.Infrastructure;
using Project1.Model;

namespace Project1.Repository
{
    public class EsercizioRepository : BaseRepositoty<Esercizio>
    {
        public EsercizioRepository(Project1Context context) : base(context)
        {
        }
    }
}
