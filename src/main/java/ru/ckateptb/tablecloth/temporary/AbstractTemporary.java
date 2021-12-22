package ru.ckateptb.tablecloth.temporary;

import lombok.Getter;
import ru.ckateptb.tablecloth.spring.SpringContext;

public abstract class AbstractTemporary implements Temporary {
    private long revertTime = -1;
    private FinalHandler finalHandler = null;
    @Getter
    private TemporaryService temporaryService;

    /**
     * Зарегистрировать объект в стандартном сервисе для временных объектов {@link TemporaryService}
     */
    public final void register() {
        this.temporaryService = SpringContext.getInstance().getBean(TemporaryService.class);
        this.temporaryService.register(this);
    }

    @Override
    public void setRevertTime(long revertTime) {
        this.revertTime = revertTime;
    }

    @Override
    public long getRevertTime() {
        return this.revertTime;
    }

    @Override
    public void setFinalHandler(FinalHandler finalHandler) {
        this.finalHandler = finalHandler;
    }

    @Override
    public FinalHandler getFinalHandler() {
        return this.finalHandler;
    }

}