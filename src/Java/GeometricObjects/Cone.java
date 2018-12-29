import vtk.vtkActor;
import vtk.vtkConeSource;
import vtk.vtkNamedColors;
import vtk.vtkNativeLibrary;
import vtk.vtkPolyDataMapper;
import vtk.vtkRenderWindow;
import vtk.vtkRenderWindowInteractor;
import vtk.vtkRenderer;

public class Cone 
{

  //-----------------------------------------------------------------
  // Load VTK library and print which library was not properly loaded
  static 
  {
    if (!vtkNativeLibrary.LoadAllNativeLibraries())
    {
      for (vtkNativeLibrary lib : vtkNativeLibrary.values()) 
      {
        if (!lib.IsLoaded()) 
        {
          System.out.println(lib.GetLibraryName() + " not loaded");
        }
      }
    }
    vtkNativeLibrary.DisableOutputWindow(null);
  }
  // -----------------------------------------------------------------
    
  public static void main(String s[]) 
  {

    vtkNamedColors colors = new vtkNamedColors();


    //For Actor Color
    double actorColor[] = new double[4];
    //Renderer Background Color
    double Bgcolor[] = new double[4];


    colors.GetColor("MediumVioletRed", actorColor);
    colors.GetColor("Wheat", Bgcolor);

    //create a Cone
    vtkConeSource ConeSource = new vtkConeSource();
    //Uncomment below line to set the Resolution of Cone
    // ConeSource.SetResolution(100);
    ConeSource.Update();

    //Create a Mapper and Actor
    vtkPolyDataMapper Mapper = new vtkPolyDataMapper();
    Mapper.SetInputConnection(ConeSource.GetOutputPort());

    vtkActor Actor = new vtkActor();
    Actor.SetMapper(Mapper);
    Actor.GetProperty().SetColor(actorColor);

    //Create the renderer, render window and interactor.
    vtkRenderer ren = new vtkRenderer();
    vtkRenderWindow renWin = new vtkRenderWindow();
    renWin.AddRenderer(ren);
    vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
    iren.SetRenderWindow(renWin);

    // Visualise the arrow
    ren.AddActor(Actor);
    ren.SetBackground(Bgcolor);

    renWin.SetSize(300, 300);
    renWin.Render();

    iren.Initialize();
    iren.Start();
  }
} 
