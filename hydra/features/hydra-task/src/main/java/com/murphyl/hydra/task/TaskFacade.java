package com.murphyl.hydra.task;

import com.murphyl.hydra.task.etl.EtlTask;
import com.murphyl.x.Feature;
import com.murphyl.x.PlugIn;

/**
 * 任务插件 - 门面
 *
 * @date: 2021/10/20 20:14
 * @author: murph
 */
@PlugIn({EtlTask.class})
public class TaskFacade implements Feature {
}
