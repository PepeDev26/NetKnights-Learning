import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.pepedev26.netknightslearning.GameManager
import com.pepedev26.netknightslearning.LivesManager

class PointsObserver(private val textView: TextView) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun updatePoints() {
        textView.text = GameManager.puntos.toString()
    }
}