package io.wojciechosak.calendar.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalCalendarView(
    modifier: Modifier = Modifier,
    pageSize: PageSize = PageSize.Fill,
    beyondBoundsPageCount: Int = 0,
    pageNestedScrollConnection: NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(
            Orientation.Horizontal,
        ),
    calendarView: @Composable (monthOffset: Int) -> Unit,
) {
    HorizontalPager(
        state =
            rememberPagerState(
                initialPage = Int.MAX_VALUE / 2,
                pageCount = { Int.MAX_VALUE },
            ),
        modifier = modifier,
        pageSize = pageSize,
        beyondBoundsPageCount = beyondBoundsPageCount,
        pageNestedScrollConnection = pageNestedScrollConnection,
    ) {
        val index = it - Int.MAX_VALUE / 2
        Column {
            calendarView(index)
        }
    }
}
