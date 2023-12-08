import { Tag } from "../../../models/enum/tag.enum";

export interface AddRestoFormData {
    name: string;
    address: string;
    tag: Tag;
}
  