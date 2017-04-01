package $package$.thrift;

import com.twitter.util.Future;
import $package$.$appName$Manager;

class $appName$ThriftService(manager: $appName$Manager) extends $appName$[Future] {

  def ping: Future[String] = Future.value(manager.getPong)
}
