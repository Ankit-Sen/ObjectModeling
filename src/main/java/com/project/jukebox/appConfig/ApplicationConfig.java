package com.project.jukebox.appConfig;

import com.project.jukebox.commands.CommandInvoker;
import com.project.jukebox.commands.CreatePlaylistCommand;
import com.project.jukebox.commands.CreateUserCommand;
import com.project.jukebox.commands.DeletePlaylistCommand;
import com.project.jukebox.commands.LoadDataCommand;
import com.project.jukebox.commands.ModifyPlaylistCommand;
import com.project.jukebox.commands.PlayPlaylistCommand;
import com.project.jukebox.commands.PlaySongCommand;
import com.project.jukebox.repositories.IPlaylistRepository;
import com.project.jukebox.repositories.ISongRepository;
import com.project.jukebox.repositories.IUserRepository;
import com.project.jukebox.repositories.PlaylistRepository;
import com.project.jukebox.repositories.SongRepository;
import com.project.jukebox.repositories.UserRepository;
import com.project.jukebox.services.ILoadDataService;
import com.project.jukebox.services.IPlaylistService;
import com.project.jukebox.services.ISongService;
import com.project.jukebox.services.IUserService;
import com.project.jukebox.services.LoadDataService;
import com.project.jukebox.services.PlaylistService;
import com.project.jukebox.services.SongService;
import com.project.jukebox.services.UserService;

public class ApplicationConfig {

    private final ISongRepository songRepository = new SongRepository();
    private final IUserRepository userRepository = new UserRepository();
    private final IPlaylistRepository playlistRepository = new PlaylistRepository();

    private final ISongService songService = new SongService(songRepository);
    private final IUserService userService = new UserService(userRepository);
    private final IPlaylistService playlistService = new PlaylistService(playlistRepository,songRepository);
    private final ILoadDataService loadDataService= new LoadDataService(songRepository);
    
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
    private final LoadDataCommand loadDataCommand = new LoadDataCommand(loadDataService);
    private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    private final PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(playlistService);
    private final ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(songService,playlistService);
    private final PlaySongCommand playSongCommand = new PlaySongCommand(playlistService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("LOAD-DATA",loadDataCommand);
        commandInvoker.register("CREATE-USER",createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST",createPlaylistCommand);
        commandInvoker.register("DELETE-PLAYLIST",deletePlaylistCommand);
        commandInvoker.register("PLAY-PLAYLIST",playPlaylistCommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyPlaylistCommand);
        commandInvoker.register("PLAY-SONG",playSongCommand);
        return commandInvoker;
    }
    
}
