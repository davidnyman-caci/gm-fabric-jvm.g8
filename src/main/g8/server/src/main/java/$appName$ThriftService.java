package $package$.thrift;

import com.twitter.util.Future;
import $package$.$appName$Manager;

public class $appName$ThriftService implements $appName$.ServiceIFace {

  private $appName$Manager manager;

  public $appName$ThriftService($appName$Manager manager) {
    this.manager = manager;
  }

  @Override
  public Future<String> ping() {
    return Future.value(manager.getPong());
  }
}
