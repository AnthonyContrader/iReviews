using Project1.Infrastructure;
using Project1.Model;

namespace Project1.Repository
{
    public class LocalitaRepository : BaseRepositoty<Localita>
    {
        public LocalitaRepository(Project1Context context) : base(context)
        {
        }
    }
}
