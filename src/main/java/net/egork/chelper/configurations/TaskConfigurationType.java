package net.egork.chelper.configurations;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import net.egork.chelper.util.Utilities;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public class TaskConfigurationType implements ConfigurationType {
    private static final Icon ICON = IconLoader.getIcon("/icons/taskIcon.png");
    private static final String DISPLAY_NAME = "Task";
    private final ConfigurationFactory factory;
    public static TaskConfigurationType INSTANCE;

    public TaskConfigurationType() {
        factory = new ConfigurationFactory(this) {
            @Override
            public RunConfiguration createTemplateConfiguration(Project project) {
                return new TaskConfiguration("Task", project, Utilities.getDefaultTask(), factory);
            }

            @Override
            public @NotNull @NonNls String getId() {
                return DISPLAY_NAME;
            }
        };
        INSTANCE = this;
    }

    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    public String getConfigurationTypeDescription() {
        return "CHelper Task";
    }

    public Icon getIcon() {
        return ICON;
    }

    @Override
    @NotNull
    public String getId() {
        return DISPLAY_NAME;
    }

    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{factory};
    }
}
