import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.pepedev26.netknightslearning.LivesManager

class LivesObserver(private val textView: TextView) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun updateLives() {
        textView.text = LivesManager.lives.toString()
    }
}