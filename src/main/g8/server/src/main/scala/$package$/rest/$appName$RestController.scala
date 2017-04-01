package $package$.rest

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

import $package$.$appName$Manager

class $appName$RestController(manager: $appName$Manager) extends Controller {

  // Keep this. Use to see if the service is accepting connections.
  get("/ping") { request: Request =>
    response.ok(manager.getPong()).toFuture
  }
}
