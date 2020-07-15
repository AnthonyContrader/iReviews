using Project1.Infrastructure;
using Project1.Model;

namespace Project1.Repository
{
    public class ProductRepository : BaseRepositoty<ProductItem>
    {
        public ProductRepository(Project1Context context) : base(context)
        {
        }
    }
}
