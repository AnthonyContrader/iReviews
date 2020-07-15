using Microsoft.EntityFrameworkCore;
using Project1.Model;
using System.Linq;

namespace Project1.Repository
{
    public abstract class BaseRepositoty<T> where T : BaseModel
    {
        private readonly DbContext _context;

        public BaseRepositoty(DbContext context)
        {
            _context = context;
        }

        public T Insert(T item)
        {
            _context.Add(item);
            _context.SaveChanges();

            return item;
        }

        public IQueryable<T> GetAll()
        {
            return _context.Set<T>();
        }

        public void Delete(int id)
        {
            _context.Set<T>().Remove(_context.Set<T>().First(a => a.Id == id));
            _context.SaveChanges();
        }
    }
}
