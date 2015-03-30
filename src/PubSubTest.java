import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

class MyJedisPubSub extends JedisPubSub{

	private String id=null;
	public MyJedisPubSub(String id){
		this.id=id;
	}
	@Override
	public void onMessage(String arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println(id+" "+arg1);
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
public class PubSubTest {
	public static void main(String[] args){
		/*
		JedisPool pool=new JedisPool(new JedisPoolConfig(),"localhost");
		Jedis jedis=pool.getResource();
		JedisPubSub mypub1=new MyJedisPubSub("sub1");
		jedis.subscribe(mypub1, "friend");
		*/
		JedisPool pool=new JedisPool(new JedisPoolConfig(),"localhost");
		Jedis jedis=pool.getResource();
		
		while(true){
			List<String> name=jedis.brpop(0,new String[]{"friend"});					
			if(name==null) continue;
			
			System.out.println(name.get(0)+" "+name.get(1));
		}
	}
}
