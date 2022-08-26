package com.proyectofinal;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/proyectofinal/DAO;", "", "deleteAll", "", "deleteTask", "entity", "Lcom/proyectofinal/Entity;", "getTasks", "", "Lcom/proyectofinal/CardInfo;", "insertTask", "updateTask", "app_debug"})
public abstract interface DAO {
    
    @androidx.room.Insert()
    public abstract void insertTask(@org.jetbrains.annotations.NotNull()
    com.proyectofinal.Entity entity);
    
    @androidx.room.Update()
    public abstract void updateTask(@org.jetbrains.annotations.NotNull()
    com.proyectofinal.Entity entity);
    
    @androidx.room.Delete()
    public abstract void deleteTask(@org.jetbrains.annotations.NotNull()
    com.proyectofinal.Entity entity);
    
    @androidx.room.Query(value = "Delete from to_do")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from to_do")
    public abstract java.util.List<com.proyectofinal.CardInfo> getTasks();
}