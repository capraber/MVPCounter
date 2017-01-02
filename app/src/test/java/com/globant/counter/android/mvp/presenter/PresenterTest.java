package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CountPresenter presenter;
    private CountModel model;
    private CountView view;

    @Before
    public void setup() {
        model = new CountModel();
        view = mock(CountView.class);
        presenter = new CountPresenter(model, view);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isShouldIncCountByOne() {
        model.reset();
        presenter.onCountButtonPressed(new CountView.CountButtonPressedEvent());
        assertEquals(model.getCount(), 1);
        verify(view).setCount("1");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void isShouldResetCount() {
        presenter.onCountButtonPressed(new CountView.CountButtonPressedEvent());
        presenter.onCountButtonPressed(new CountView.CountButtonPressedEvent());
        presenter.onCountButtonPressed(new CountView.CountButtonPressedEvent());
        assertEquals(model.getCount(), 3);
        presenter.onResetButtonPressed(new CountView.ResetButtonPressedEvent());
        assertEquals(model.getCount(), 0);
        verify(view, times(4)).setCount(anyString());
        verifyNoMoreInteractions(view);
    }
}