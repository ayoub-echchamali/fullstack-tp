import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appTableYellowOrRed]',
  standalone: true
})
export class TableYellowOrRedDirective {

  @Input()
  set appTableYellowOrRed(value: string) {
    if (parseInt(value) < 1) {
      this.renderer.setStyle(this.elRef.nativeElement, "color", "yellow");
    } else if (parseInt(value) > 2){
      this.renderer.setStyle(this.elRef.nativeElement, "color", "red");
    }
  }

  constructor(private elRef: ElementRef, private renderer: Renderer2) {
  }

}
