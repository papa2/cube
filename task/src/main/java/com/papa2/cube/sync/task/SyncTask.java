package com.papa2.cube.sync.task;

import com.papa2.cube.api.sync.ISyncService;

public class SyncTask {

	private ISyncService syncService;

	public void sync() {
		syncService.sync();
	}

	public ISyncService getSyncService() {
		return syncService;
	}

	public void setSyncService(ISyncService syncService) {
		this.syncService = syncService;
	}

}
