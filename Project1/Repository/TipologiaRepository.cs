using Project1.Infrastructure;
using Project1.Model;

namespace Project1.Repository
{
    public class TipologiaRepository : BaseRepositoty<Tipologia>
    {
        public TipologiaRepository(Project1Context context) : base(context)
        {
        }
    }
}
