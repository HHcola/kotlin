// FILE: 1.kt
// FULL_JDK

package test
import java.util.concurrent.Executors

inline fun doWork(noinline job: ()-> Unit) {
    Executors.callable(job).call()
}

// FILE: 2.kt

//NO_CHECK_LAMBDA_INLINING
import test.*

fun box() : String {
    var result = "fail"
    doWork { result = "O1K" }

    return result
}
