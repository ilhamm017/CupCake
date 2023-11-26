data class OrderUiState(
    val jumlah: Int = 0,
    val rasa: String = "",
    val tanggal: String = "",
    val harga: String = "",
    val pengambilan: List<String> = listOf()
)