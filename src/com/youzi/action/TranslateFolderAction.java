package com.youzi.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

/**
 * @author hj
 * @date 2019/5/2
 */
public class TranslateFolderAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent event) {
        //获取文件名称

        Project project = event.getProject();
        System.out.println(project.getBasePath() );

        // 获取当前选择的文件或文件夹路径
        VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(event.getDataContext());
        if(file == null) {
            return;
        }
        // 获取统计路径
        String path = file.getPath();
        System.err.println(path);

    }
}
