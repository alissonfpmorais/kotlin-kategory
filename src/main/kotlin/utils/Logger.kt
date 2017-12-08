package utils

object Logger {
    fun debug(msg : String) = println("[Debug] $msg")
    fun error(msg : String) = println("[Error] $msg")
    fun verbose(msg : String) = println("[Verbose] $msg")
}