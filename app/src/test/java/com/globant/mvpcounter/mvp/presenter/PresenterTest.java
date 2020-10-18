package com.globant.mvpcounter.mvp.presenter;

import com.globant.mvpcounter.mvp.model.CountModel;
import com.globant.mvpcounter.mvp.view.CountView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isShouldIncCountByOne() {
        model.reset();
        presenter.onCountButtonPressed();
        assertEquals(model.getCount(), 1);
        verify(view).setCount("1");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void isShouldResetCount() {
        presenter.onCountButtonPressed();
        presenter.onCountButtonPressed();
        presenter.onCountButtonPressed();
        assertEquals(model.getCount(), 3);
        presenter.onResetButtonPressed();
        assertEquals(model.getCount(), 0);
        verify(view, times(4)).setCount(anyString());
        verifyNoMoreInteractions(view);
    }
}