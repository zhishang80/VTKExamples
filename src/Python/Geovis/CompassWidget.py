#!/usr/bin/env python
import vtk

def main():
    colors = vtk.vtkNamedColors()
    #sphere 1
    sphereSource = vtk.vtkSphereSource()
    sphereSource.SetCenter(0.0, 0.0, 0.0)
    sphereSource.SetRadius(4.0)
    
    mapper = vtk.vtkPolyDataMapper()
    mapper.SetInputConnection(sphereSource.GetOutputPort())
    
    actor = vtk.vtkActor()
    actor.SetMapper(mapper)
    
    # a renderer and render window
    renderer = vtk.vtkRenderer()
    renderWindow = vtk.vtkRenderWindow()
    renderWindow.AddRenderer(renderer)
    
    # an interactor
    renderWindowInteractor = vtk.vtkRenderWindowInteractor()
    renderWindowInteractor.SetRenderWindow(renderWindow)
    
    # Create the widget and its representation
    compassRepresentation = vtk.vtkCompassRepresentation()
    
    compassWidget = vtk.vtkCompassWidget()
    compassWidget.SetInteractor(renderWindowInteractor)
    compassWidget.SetRepresentation(compassRepresentation)
    
    # add the actors to the scene
    renderer.AddActor(actor)
    renderer.SetBackground(colors.GetColor3d("gray")) # Background color white
    renderWindow.Render()
    compassWidget.EnabledOn()
    
    style = vtk.vtkInteractorStyleTrackballCamera()   
    renderWindowInteractor.SetInteractorStyle( style )
    
    # begin interaction
    renderWindowInteractor.Start()

if __name__ == '__main__':
    main()
