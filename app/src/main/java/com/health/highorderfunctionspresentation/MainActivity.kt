package com.health.highorderfunctionspresentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    // lambda

    private var lambda = { print("hey") }

    // Syntax
    // lambda with return type specify externally (not required if there's no arguments)
    private var lambdaWithUnit: () -> Unit = { print("hey") }


    // -------------------- Multiple Variations of Lambdas --------------------

    // lambda with return type
    private var lambdaWithIntReturn: () -> Int = { 3 }

    // lambda with one argument and return type as Unit
    private var lambdaWithoutReturnButArgument: (Int) -> Unit = { value-> print(value) }

    // lambda with one argument and return type as Unit Alternate Way
    // Return type will depend on the expression in this case if we don't define explicitly
    private var lambdaWithoutReturnButArgumentAlternateWay = { value: Int -> print(value) }

    // lambda with both argument and return type
    private var lambdaWithArgument: (Int) -> Int = { value -> value }

    // lambda with multiple arguments
    private var lambdaWithMultipleArguments1: (Int, Int) -> Int = { value1, value2 -> value1 + value2 }

    // lambda with multiple arguments and one argument is not in use
    private var lambdaWithMultipleArguments2: (Int, Int) -> Int = { value1, _ -> value1 }


    // ------------------ Calling lambdas ------------


    fun getLambdaWithOneArgument(): Int {
        return lambdaWithArgument(1)
    }

    val result = lambdaWithMultipleArguments1(2, 3)

    // preference will be given to functions if name is same for lambda and a function
    private fun lambdaWithMultipleArguments1(value1: Int, value2: Int): Int {
        return value1 + value2
    }



   // Now What's the Benefit of lambda if same can be done with functions?

   // Lambdas are treated as Objects which can be passed as argument and can be returned as a value

   // Here comes High order function into Picture

   // - See Example below:-

    private fun passLambda(printNow: ()-> Unit) : Unit{
        // anything you want to do
        var add = 2 + 3
        printNow()
    }

    // call passLambda

    var callPassLambda1 = passLambda( { print("hey") } )





    // call passLambda another way
    var callPassLambda2 = passLambda { print("hey") }


    // Alternate way to call passlambda
    var callPassLambdaAlternate =
            passLambda {
                fun printNow() {
                    print("hey")
                }
            }


    private fun passLambda1(value1: Int, value2: (Int, Int)-> Int) : Unit{
        var total = value1 + value2(10,5)
    }

    // for flexibility


    // Result will be = 2+10+15 = 17
    var h1 = passLambda1(2, lambdaWithMultipleArguments1)

    // Result will be = 2+10-5 = 7
    var h2 = passLambda1(2) { value1: Int, value2: Int -> value1 - value2 }






    // return lambdas as a function

    private fun returnAdd() : ((Int, Int) -> Int){
        return ::add
    }

    private fun add (a: Int, b:Int) : Int{
        return a + b
    }

    val add1 = returnAdd()
    val result1 = add1(2,3)




}

