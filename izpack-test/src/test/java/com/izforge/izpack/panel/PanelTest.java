package com.izforge.izpack.panel;

import com.izforge.izpack.api.data.ResourceManager;
import com.izforge.izpack.installer.container.IInstallerContainer;
import com.izforge.izpack.installer.data.GUIInstallData;
import com.izforge.izpack.installer.manager.PanelManager;
import com.izforge.izpack.integration.AbstractIntegrationTest;
import com.izforge.izpack.panels.target.TargetPanel;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Integration test for panels
 */
@Test(groups = "integration")
public class PanelTest extends AbstractIntegrationTest
{
    @Test
    public void testInfoPanelResource() throws Exception
    {
        compileInstallJar("basicInstall.xml", getWorkingDirectory("samples/basicInstall"));
        ResourceManager resourceManager = applicationContainer.getComponent(ResourceManager.class);
        String resNamePrifix = "InfoPanel.info";
        String info = resourceManager.getTextResource(resNamePrifix);
        assertThat(info, Is.is("A readme file ..."));
    }

    @Test
    public void testLicencePanelResource() throws Exception
    {
        compileInstallJar("basicInstall.xml", getWorkingDirectory("samples/basicInstall"));
        ResourceManager resourceManager = applicationContainer.getComponent(ResourceManager.class);
        String resNamePrifix = "LicencePanel.licence";
        String info = resourceManager.getTextResource(resNamePrifix);
        assertThat(info, Is.is("(Consider it as a licence file ...)"));
    }

    @Test
    public void testTargetPanel() throws Exception
    {
        compileInstallJar("basicInstall.xml", getWorkingDirectory("samples/basicInstall"));

        GUIInstallData installData = applicationContainer.getComponent(GUIInstallData.class);
        installerContainer = applicationContainer.getComponent(IInstallerContainer.class);
        PanelManager panelManager = installerContainer.getComponent(PanelManager.class);
        panelManager.loadPanelsInContainer();
        panelManager.instanciatePanels();

        TargetPanel targetPanel = installerContainer.getComponent(TargetPanel.class);
        targetPanel.loadDefaultDir();
        String defaultDir = installData.getInstallPath();
        System.out.println(installData.getInstallPath());

        File file = new File(defaultDir);
        if (file.exists())
        {
            file.delete();
        }
    }
}
