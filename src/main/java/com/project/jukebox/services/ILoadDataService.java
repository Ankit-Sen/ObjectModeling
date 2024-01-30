package com.project.jukebox.services;

import java.io.FileNotFoundException;

public interface ILoadDataService {

    public void loadData(String fileName) throws FileNotFoundException;

}
