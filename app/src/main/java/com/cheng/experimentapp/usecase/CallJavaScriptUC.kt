package com.cheng.experimentapp.usecase

import org.mozilla.javascript.Scriptable
import timber.log.Timber
import java.io.InputStreamReader

object CallJavaScriptUC {

    fun callFunction(context: android.content.Context, filePath: String, functionName: String): Any? {
        var jsResult: Any? = null
        // Every Rhino VM begins with the enter()
        val rhino = org.mozilla.javascript.Context.enter()
        // Turn off optimization to make Rhino Android compatible
        rhino.optimizationLevel = -1
        try {
            val scope: Scriptable = rhino.initStandardObjects()
            val input = context.assets.open(filePath)
            val targetReader = InputStreamReader(input)
            // Note the forth argument is 1, which means the JavaScript source has
            // been compressed to only one line using something like YUI
            rhino.evaluateReader(scope, targetReader, "JavaScript", 1, null)
            // Get the functionName defined in JavaScriptCode
            val obj = scope.get(functionName, scope)
            if (obj is org.mozilla.javascript.Function) {
                val params = arrayOf<Any>("")
                // Call the function with params
                jsResult = obj.call(rhino, scope, scope, params)
                // Parse the jsResult object to a String
                val result = org.mozilla.javascript.Context.toString(jsResult)
                Timber.e("trpb67, result is $result")
            }
            targetReader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            org.mozilla.javascript.Context.exit()
        }

        return jsResult
    }
}
