package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayHeaderItem(matcher: Matcher<View>) : KRecyclerItem<DayHeaderItem>(matcher) {
    val dayHeaderText = KTextView(matcher){
        withId(R.id.day_header_text)
    }
}