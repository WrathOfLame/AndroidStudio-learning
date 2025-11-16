<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        style="@style/NaglowekEkranu"
        android:text="Panel Ustawień" />
    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Włącz tryb PRO"
        android:textSize="18sp"
        android:checked="true" />
    <Button
        style="@style/PrzyciskGlowny"
        android:text="Zapisz ustawienia" />

</LinearLayout>
