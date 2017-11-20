// !WITH_NEW_INFERENCE
// !CHECK_TYPE

//KT-731 Missing error from type inference
package a

class A<T>(x: T) {
    val p = x
}

fun <T, G> A<T>.foo(x: (T)-> G): G {
    return x(this.p)
}

fun main(args: Array<String>) {
    val a = A(1)
    val t: String = a.<!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH!>foo({p -> <!TYPE_MISMATCH!>p<!>})<!>
    checkSubtype<String>(t)
}