
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Tutorial {

	public static void main(String[] args){
		JedisPool pool=new JedisPool(new JedisPoolConfig(),"localhost");
		
		
		Jedis jedis=pool.getResource();

		jedis.publish("friend", "jackson");

		
		//Person p=new Person(1,"a");
		
		//jedis.set("person".getBytes(), SerializeUtil.serialize(p));
		/*
		for(int i=1;i<100000;i++){
			Person p=new Person(i,String.valueOf(i));
			jedis.set(("person"+i).getBytes(), SerializeUtil.serialize(p));
			System.out.println(i);
		}
		*/
		//Person p=(Person)SerializeUtil.unserialize(jedis.get("person".getBytes()));
		//System.out.println(p.getId()+" "+p.getName());
		//System.out.println(jedis.get("friend"));
		
	}
	
}
