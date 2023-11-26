import androidx.lifecycle.ViewModel

class TampilanPesananModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
}