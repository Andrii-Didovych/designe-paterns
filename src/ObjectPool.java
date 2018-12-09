import java.util.ArrayList;
import java.util.List;

public class ObjectPool {

    public static void main(String[] args) {
        Pool pool = new Pool();
        PooledObject poolObject = pool.getPoolObject();
        pool.releasePooledObject(poolObject);
    }
}

class PooledObject {

}

class Pool {

    List<PooledObject> free = new ArrayList<>();
    List<PooledObject> used = new ArrayList<>();

    public PooledObject getPoolObject() {
        if (free.isEmpty()) {
            PooledObject pooledObject = new PooledObject();
            used.add(pooledObject);
            return pooledObject;
        }else {
            PooledObject pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
            return pooledObject;
        }
    }

    public void releasePooledObject(PooledObject pooledObject) {
        used.remove(pooledObject);
        free.add(pooledObject);
    }
}
