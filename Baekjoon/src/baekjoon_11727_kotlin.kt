import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    var dp = Array<Int>(1001, { 0 })
    dp[1] = 1;
    dp[2] = 3;
    for (i in 3..n)
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    print(dp[n])
}