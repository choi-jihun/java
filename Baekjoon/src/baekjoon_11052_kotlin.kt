import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    var dp = Array(N + 1, { 0 })
    var card = Array(N + 1, { 0 })
    var st = StringTokenizer(readLine())
    for (i in 1..N)
        card[i] = st.nextToken().toInt()
    for (i in 1..N)
        for (j in 1..i)
            dp[i] = Math.max(dp[i], card[j] + dp[i - j])
    println(dp[N])
}