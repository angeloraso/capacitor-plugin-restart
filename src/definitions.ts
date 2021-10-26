export interface RestartPlugin {
  enable(): Promise<void>;
  disable(): Promise<void>;
}
