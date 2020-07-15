using Project1.Infrastructure;
using Project1.Model;

namespace Project1.Repository
{
    public class ReviewRepository : BaseRepositoty<Review>
    {
        public ReviewRepository(Project1Context context) : base(context)
        {
        }
    }
}
