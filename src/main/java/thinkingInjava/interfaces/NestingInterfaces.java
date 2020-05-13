package thinkingInjava.interfaces;

/**
 * @author hike97 2month
 * @create 2020-04-20 0:31
 * @desc 嵌套接口
 **/
class A {
	//包访问权限
	interface B {
		void f ();
	}

	public class BImp implements B {
		@Override
		public void f () {

		}
	}

	private class BImp2 implements B {
		@Override
		public void f () {

		}
	}

	//public
	public interface C {
		void f ();
	}

	class CImp implements C {
		@Override
		public void f () {

		}
	}

	private class Cimp2 implements C {
		@Override
		public void f () {

		}
	}

	//private
	private interface D {
		void f ();
	}

	private class DImp implements D {
		@Override
		public void f () {

		}
	}

	public class Dimp2 implements D {
		@Override
		public void f () {

		}
	}

	private D dRef;

	public D getD () {
		return new Dimp2 ();
	}

	public void receiveD (D d) {
		dRef = d;
		dRef.f ();
	}
}

interface E {
	interface G {
		void f();
	}

	public interface H {
		void f();
	}

	void g();

//	private interface I{} 嵌套接口无法是private的
}
public class NestingInterfaces {
	public class BImp implements A.B{
		@Override
		public void f () {

		}
	}
	class CImp implements A.C{
		@Override
		public void f () {

		}
	}
    //无法执行private 接口
//	class DImp implements A.D{
//		@Override
//		public void f () {
//
//		}
//	}

	class EImp implements E {
		@Override
		public void g () {

		}
	}

	class EGImp implements E.G {
		@Override
		public void f () {

		}
	}

	class EGImp2 implements E{
		@Override
		public void g () {

		}
		class EG implements E.G{
			@Override
			public void f () {

			}
		}
	}

	public static void main (String[] args) {
		A a = new A ();
//		A.D ad = a.getD(); 没有访问权限
		A.Dimp2 di2 = (A.Dimp2) a.getD ();
//		a.getD ().f ();//无法获取接口的方法
		a.receiveD (a.getD ());
	}
}