import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestoDetailsComponent } from './resto-details.component';

describe('RestoDetailsComponent', () => {
  let component: RestoDetailsComponent;
  let fixture: ComponentFixture<RestoDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestoDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
