package softuni.OOP.solid.SingleResponsibility.DrawingShape;

import softuni.OOP.solid.SingleResponsibility.DrawingShape.Interfaces.Shape;
import softuni.OOP.solid.SingleResponsibility.DrawingShape.Interfaces.DrawingManager;
import softuni.OOP.solid.SingleResponsibility.DrawingShape.Interfaces.DrawingRepository;
import softuni.OOP.solid.SingleResponsibility.DrawingShape.Interfaces.Renderer;

public class DrawingManagerImpl implements DrawingManager {
    private final DrawingRepository drawingRepository;
    private final Renderer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Renderer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }

    @Override
    public void draw(softuni.OOP.polymorphism.Shapes.Shape shape) {
        renderer.render(drawingRepository, (Shape) shape);
    }
}
