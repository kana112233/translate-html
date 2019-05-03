package com.youzi.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.youzi.Logger;
import com.youzi.constant.Contstants;
import com.youzi.util.GoogleTranslateUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 控制器
 * @author tangyouzhi  SuTranslate
 */
public class TranslateAction extends AnAction {

    TranslateJob translateJob = new TranslateJob();

    @Override
    public void actionPerformed(AnActionEvent event) {
        Logger.init(this.getClass().getSimpleName(), 1);
        executeTranslate(event);
    }

    /**
     * 执行翻译操作
     * @param event
     */
    private void executeTranslate(AnActionEvent event){
        final Editor mEditor = (Editor) event.getData(PlatformDataKeys.EDITOR);

        if (null == mEditor) {
            return;
        }
        final SelectionModel selectionModel = mEditor.getSelectionModel();
        String selectText = selectionModel.getSelectedText();

        String[] strings = selectText.split("\n\n");
        StringBuilder translateString = new StringBuilder();
        for (String string : strings) {
            System.err.println(strings);
            translateString.append(translateJob.parseString(mEditor, string)+"\n\n");
        }
        //修正文本
        //1 批量修改中文括号到英文
        String backString = translateString.toString().replaceAll("（","(");
        backString = backString.replaceAll("）",")");

        //获取文件名称
        PsiFile psiFile = event.getData(LangDataKeys.PSI_FILE);
        if (psiFile != null) {
            String path = psiFile.getVirtualFile().getParent().getPath();
            int index = psiFile.getName().lastIndexOf(".");
            String fileName = psiFile.getName().substring(0, index);
            File file = new File(path+File.separator+fileName+".hj");
            try {
                FileOutputStream os = new FileOutputStream(file);
                os.write(backString.getBytes("UTF-8") );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        GoogleTranslateUtil.showPopupBalloon("翻译结束");

    }




}
